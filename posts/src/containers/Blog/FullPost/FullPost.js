import React, { Component } from "react";
import axios from "axios";

import "./FullPost.css";

class FullPost extends Component {
  state = {
    loadedPost: null,
  };

  componentDidMount() {
    console.log("[FullPost.js] componentDidMount: "+this.props.match.params.id);
    this.loadData();
  }
  

  loadData(){
    if (this.props.match.params.id) {
      if (
        !this.state.loadedPost ||
        (this.state.loadedPost && this.state.loadedPost.id !== +this.props.match.params.id)
      ) {
        axios
          .get("/posts/" + this.props.match.params.id)
          .then((response) => {
            console.log('Refresh............[FullPost.js]'+ response);
            this.setState({ loadedPost: response.data });
            //Can also be done via history push
            //Redirect replaces the page so back button wont give you this page, redirect == histpry.replace(url)
          });
      }
    }
  }

  componentDidUpdate(){
      console.log("[Posts.js ] componentDidUpdate ", this.props.match.params.id);
      this.loadData();
  }

  deletePostHandler = () => {
    axios.delete('/posts/'+ this.props.match.params.id)
    .then(response => {
        console.log(response);
    })
  };

  render() {
    let post= null;
   // let post = <p style={{ textAlign: "center" }}>Please select a Post!</p>;
    if (!this.state.loadedPost) {
      post = <p style={{ textAlign: "center" }}>Loading...!</p>;
    }
    if (this.state.loadedPost) {
      post = (
        <div className="FullPost">
          <h1>{this.state.loadedPost.title}</h1>
          <p>{this.state.loadedPost.body}</p>
          <div className="Edit">
            <button onClick= {this.deletePostHandler} className="Delete">Delete</button>
          </div>
        </div>
      );
    }

    return post;
  }
}

export default FullPost;
