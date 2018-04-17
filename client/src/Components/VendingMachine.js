import React, { Component } from 'react';
import TextDisplay from "TextDisplay"

class VendingMachine extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="VendingMachine">
        <TextDisplay name="message"/>
        <TextDisplay name = "credit"/>
        <DisplayCabinet/>
        <CoinPanel/>
        <ActionButton name="vend"/>
        <ActionButton name="service"/>
        <ActionButton name="coin return"/>
      </div>
    );
  }
}

export default Coin;
