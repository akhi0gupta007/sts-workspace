import React, { Component } from "react";
import {Route,Link} from 'react-router-dom'

import Posts from "../Blog/Posts/Posts"
import NewPost from "../Blog/NewPost/NewPost"
import "./Blog.css";

class Blog extends Component {

  render() {
  
    return (
      <div className="Blog">
        <header>
        <nav>
          <ul>
            <li><Link to="/">Home</Link> </li>
            <li><Link to={{
              pathname:'/new-post',
            //  pathname:this.props.match.url + '/new-post', This is relative path
              hash:'#submit',
              search:'?quick-submit=true'
            }}>New Post</Link></li>
          </ul>
        </nav>
        </header>
        {/* <Route path="/" exact render={() => <h1>Home</h1>} /> */}
        <Route path="/" exact component={Posts}/>
        <Route path="/new-post"  component={NewPost}/>
      </div>
    );
  }
}

export default Blog;
