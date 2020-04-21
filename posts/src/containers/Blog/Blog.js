import React, { Component } from "react";
import { Route, NavLink, Switch } from "react-router-dom";

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
                <NavLink to="/" exact>
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
        <Route path="/"  component={Posts} />       
           
                   
        </Switch>
      </div>
    );
  }
}

export default Blog;
