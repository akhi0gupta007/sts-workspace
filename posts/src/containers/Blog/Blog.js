import React, { Component } from "react";
import { Route, NavLink, Switch,Redirect } from "react-router-dom";

import Posts from "../Blog/Posts/Posts";
import NewPost from "../Blog/NewPost/NewPost";

import "./Blog.css";

class Blog extends Component {
  render() {
    return (
      <div className="Blog">
        <header>
          <nav>
            <ul>
              <li>
                <NavLink to="/posts" exact>
                  Posts
                </NavLink>{" "}
              </li>
              <li>
                <NavLink
                  to={{
                    pathname: "/new-post",
                    //  pathname:this.props.match.url + '/new-post', This is relative path
                    hash: "#submit",
                    search: "?quick-submit=true",
                  }}
                >
                  New Post
                </NavLink>
              </li>
            </ul>
          </nav>
        </header>
        {/* <Route path="/" exact render={() => <h1>Home</h1>} /> */}
        
        <Switch> {/* This tag only loads one route (best match first), not all of them */}        
        <Route path="/new-post" component={NewPost} />    
        <Route path="/posts"  component={Posts} />      
        <Redirect from="/" to="/posts"/> {/* 
        This / (root) URL  catches everything and all URLS, alternatively we can just define Route without path component
        <Route exact render={() => <h1>Not found</h1>
        */}
        {/* <Route path="/"  component={Posts} />    */}   
                   
        </Switch>
      </div>
    );
  }
}

export default Blog;
