import React, { Component } from "react";
import Coin from "./Coin.js";

class CoinPanel extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="CoinPanel">
        <Coin/>
        // render all coins here
      </div>
    );
  }
}

export default CoinPanel;
