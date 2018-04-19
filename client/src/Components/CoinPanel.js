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
        <Coin type={coin.type} value={coin.value}  key={this.props.coins.indexOf(coin)} onClick={this.props.onClick}/>
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
