import React, { Component } from "react";
import axios from "../../../axios";

import "./Posts.css";
import Post from "../../../components/Post/Post";
import Spinner from "../../../components/Spinner/Spinner";

class Posts extends Component {
  state = {
    posts: [],
    loaded: false,
  };

  componentDidMount() {
    console.log("[Blog.js ]componentDidUpdate ",this.props);
    axios
      .get("/posts")
      .then((response) => {
        console.log(response);
        const post = response.data.slice(0, 4);
        const updatedPosts = post.map((post) => {
          return {
            ...post,
            author: "Max",
          };
        });
        this.setState({ posts: updatedPosts, loaded: true });
      })
      .catch((error) => {
        console.log(error);
      });
  }

  postSelectedHandler = (id) => {
    this.setState({ selectedPostId: id });
  };

  render() {
    let posts = <Spinner />;
    if (this.state.loaded) {
      posts = this.state.posts.map((post) => {
        return (
          <Post
            key={post.id}
            title={post.title}
            author={post.author}
            clicked={() => this.postSelectedHandler(post.id)}
          />
        );
      });      
    }

    return <section className="Posts">{posts}</section>;
  }
}

export default Posts;
