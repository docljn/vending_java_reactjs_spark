import React, { Component } from "react";
import VendingMachine from "./Components/VendingMachine";
import "./App.css";

class App extends Component {
  render() {
    return (
      <div className="App">
        <VendingMachine />
      </div>
    );
  }
}

export default App;
