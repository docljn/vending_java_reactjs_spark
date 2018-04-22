import React, { Component } from "react";
import CoinImage from "../images/CoinImage";

class Coin extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="coin">
        <img src={CoinImage[this.props.type]} alt={"pic of "+this.props.type}/>
        <br/>
        <input type="submit" id={this.props.type} value={"Add "+this.props.type} onClick={this.props.coinClick}/>
      </div>
    );
  }
}

export default Coin;
