import React, { Component } from "react";
import TextDisplay from "./TextDisplay.js";
import DisplayCabinet from "./DisplayCabinet.js";
import CoinPanel from "./CoinPanel.js";
import ActionButton from "./ActionButton.js";


class VendingMachine extends Component {

  constructor(props) {
    super(props);
    // get all details of vending machine and set state here.....
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="VendingMachine">
        <TextDisplay name="message"/>
        <TextDisplay name="credit"/>
        <DisplayCabinet/>
        <CoinPanel/>
        <ActionButton name="vend"/>
        <ActionButton name="service"/>
        <ActionButton name="coin return"/>
      </div>
    );
  }
}

export default VendingMachine;
