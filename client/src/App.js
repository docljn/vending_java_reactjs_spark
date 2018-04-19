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
    this.updateState = this.updateState.bind(this);

    let itemRequest =
    fetch("http://localhost:4567/items",{mode: "no-cors"})
      .then(function(response) {
        return response.json();
      })
      .catch(error => console.error(error));

    let coinRequest =
    fetch("http://localhost:4567/coins",{mode: "no-cors"})
      .then(function(response) {
        return response.json();
      })
      .catch(error => console.error(error));

    let config = {"items": [], "coins":[]};
    Promise.all([coinRequest, itemRequest]).then(function(values){
      config["items"] = values[1];
      config["coins"] = values[0];
      return config;
    }).then(this.updateState(config));
  }

  updateState(object){
    this.setState({
      coins: object["coins"],
      items: object["items"]
    });
  }

  render() {
    if(this.state.items.length === 0){
      return <h1>LOADING...</h1>;
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
