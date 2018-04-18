import React, { Component } from "react";
import Coin from "./Coin.js";

class CoinPanel extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render(){
    const html = this.props.coins.map(coin => {
      return (
        <Coin name={coin.name} value={coin.value} count = {coin.count} />
      );
    });


    return (
      <div className="coin-panel">
        {html}
      </div>
    );
  }
}

export default CoinPanel;
