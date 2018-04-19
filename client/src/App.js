import React, { Component } from "react";
import VendingMachine from "./Components/VendingMachine";
import "./App.css";

class App extends Component {

  constructor(){
    super();
    this.state = {
      coins: [],
      items: []
    };
  }

  componentDidMount() {
    this.loadConfig("http://localhost:4567/coins", "coins");
    this.loadConfig("http://localhost:4567/items", "items");
  }

  loadConfig(url, item) {
    const request = new XMLHttpRequest();
    request.open("GET", url);
    request.addEventListener("load", () => {
      if (request.status === 200) {
        const jsonString = request.responseText;
        const itemArray = JSON.parse(jsonString);
        console.log(item);
        this.setState({item: itemArray});
      }
    });
    request.setRequestHeader("Access-Control-Allow-Origin", "localhost:4567")
    request.send();
  }


  render() {
    if(this.state.items.length === 0 || this.state.coins.length === 0){
      return (
        <div className="App">
          <h1>LOADING...</h1>;
        </div>);
    } else {
      return (
        <div className="App">
          <VendingMachine coins={this.state.coins} items={this.state.items}/>
        </div>
      );
    }
  }
}

export default App;
