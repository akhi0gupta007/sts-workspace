import React, { Component } from "react";
import axios from "../../../axios";
import {Route} from "react-router-dom";

import "./Posts.css";
import Post from "../../../components/Post/Post";
import Spinner from "../../../components/Spinner/Spinner";
import FullPost from "../FullPost/FullPost"

class Posts extends Component {
  state = {
    posts: [],
    loaded: false,
  };

  componentDidMount() {
    console.log("[Posts.js ]componentDidUpdate ", this.props);
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
    //this.props.history.push({ pathname: "/posts/" + id }); alternative
    this.props.history.push("/" + id ); //simpler
  };

  render() {
    let posts = <Spinner />;
    if (this.state.loaded) {
      posts = this.state.posts.map((post) => {
        return (
          /*     <Link   key={post.id} to={'/posts/' + post.id}>  */
          <Post
            key={post.id}
            title={post.title}
            author={post.author}
            clicked={() => this.postSelectedHandler(post.id)}
          />
          /*    </Link> */
        );
      });
    }

    return( 
    <div>
      <section className="Posts">
        {posts}
      </section>
      <Route path="/:id" exact component={FullPost} />
    </div>
    );
  }
}

export default Posts;
