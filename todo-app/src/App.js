import React,{Component} from 'react';
import TestComponent ,{TestComponent2} from './components/learning-examples/TestComponent'
import TestComponent3 from './components/learning-examples/TestComponent3'
import Counter from './components/counter/Counter'
//Remember : Non-default classes from module requires curly braces
import './App.css';

//This is class component, used for rendring
// The HTML code inside the return method is actually called as JSX (can only have one root element), and it is possible due to Babel 
//Go to Try it out section of Babel
//Component name must have first letter as Capital letter
class App extends Component {
  render() {
    return (
      <div className="App">  
      <Counter/>
      </div>
    );
  }
}

class LearningComponent extends Component{
  render(){
    return(
      <div className="LearningComponent">               
        Hello World!
        <TestComponent/>
        <TestComponent2/>
        <TestComponent3/>
        <TestFunctionComponent/>
      </div>
    );
  }
}

//This is function component
function TestFunctionComponent(){  
    return(
      <div className="App">       
        Hello TestFunctionComponent
      </div>
    );  
}



export default App;
