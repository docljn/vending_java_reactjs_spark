import React, { Component } from "react";
import TextDisplay from "./TextDisplay.js";
import DisplayCabinet from "./DisplayCabinet.js";
import CoinPanel from "./CoinPanel.js";
import ActionButton from "./ActionButton.js";


class VendingMachine extends Component {

  constructor(props) {
    super(props);
    console.log("Vending Machine Props " + JSON.stringify(props));
    this.state = {
      message: "Please make a selection",
      credit: "0.00",
      selected:{},  // not sure if I even need this!?
      coins: this.props.coins,
      items: this.props.items
    };
    this.handleCoinClick = this.handleCoinClick.bind(this);
    this.handleSelectClick = this.handleSelectClick.bind(this);
    this.handleServiceClick = this.handleServiceClick.bind(this);
    this.handleCoinReturnClick = this.handleCoinReturnClick.bind(this);
    this.handleVendClick = this.handleVendClick.bind(this);
    // get all details of vending machine and set state here.....
  }

  render() {
    return (
      <div className="vending-machine">
        <h1>Vending Machine</h1>
        <div className="user-action flex">
          <div className="item-action flex-vertical">
            <TextDisplay message={this.state.message}/>
            <DisplayCabinet items={this.props.items} onClick={this.handleSelectClick}/>
            <ActionButton name="vend" onClick = {this.handleVendClick} />
          </div>

          <div className="coin-action flex-vertical">
            <TextDisplay message={this.state.credit}/>
            <CoinPanel coins={this.props.coins} onClick={this.handleCoinClick}/>
            <ActionButton name="coin return" onClick = {this.handleCoinClick}/>
          </div>
        </div>
        <div className="service-action">
          <ActionButton name="service" onClick = {this.handleServiceClick}/>
        </div>
      </div>


    );
  }




  handleVendClick(event) {
    event.preventDefault();
    console.log(event.target);

    // put request to /vend/:selectedItem
  }

  handleCoinReturnClick(event) {
    event.preventDefault();
    console.log(event.target);


    // put request to /return
  }

  handleServiceClick(event) {
    // put request to /service
    event.preventDefault();

    console.log(event.target);


  }

  handleSelectClick(event){
    event.preventDefault();
    console.log(event.target);

    // put request to /select/:clickedItem
  }

  handleCoinClick(event){
    event.preventDefault();
    console.log(event.target);

    // put request to /coin/:clickedCoin
  }

}

export default VendingMachine;
