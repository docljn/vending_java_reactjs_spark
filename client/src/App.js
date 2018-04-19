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
    this.loadCoins = this.loadCoins.bind(this);
    this.loadItems = this.loadItems.bind(this);
  }



  loadCoins(url) {
    const request = new XMLHttpRequest();
    request.open("GET", url);
    request.addEventListener("load", (item) => {
      if (request.status === 200) {
        const jsonString = request.responseText;
        const itemArray = JSON.parse(jsonString);
        this.setState({coins: itemArray});
      }
    });
    request.send();
  }

  loadItems(url) {
    const request = new XMLHttpRequest();
    request.open("GET", url);
    request.addEventListener("load", (item) => {
      if (request.status === 200) {
        const jsonString = request.responseText;
        const itemArray = JSON.parse(jsonString);
        this.setState({items: itemArray});
      }
    });
    request.send();
  }

  componentDidMount() {
    this.loadCoins("http://localhost:4567/coins");
    this.loadItems("http://localhost:4567/items");
  }


  render() {
    if(this.state.items.length === 0 || this.state.coins.length === 0){
      return (
        <div className="App">
          <h1>LOADING...</h1>
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
