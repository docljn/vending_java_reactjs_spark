import React, { Component } from "react";
import Coin from "./Coin.js";
import Images from "../images/Images";

class CoinPanel extends Component {

  constructor(props) {
    super(props);
  }

  render(){
    const html = this.props.coins.map(coin => {
      return (
        <Coin type={coin.type} key={this.props.coins.indexOf(coin)} coinClick={this.props.coinClick}/>
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
