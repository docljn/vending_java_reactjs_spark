import React, { Component } from "react";
import TextDisplay from "./TextDisplay.js";
import DisplayCabinet from "./DisplayCabinet.js";
import CoinPanel from "./CoinPanel.js";
import ActionButton from "./ActionButton.js";


class VendingMachine extends Component {

  constructor(props) {
    super(props);
    this.state = {
      message: "Please make a selection",
      availableCredit: "$0.00",
      coins: this.props.coins,
      items: this.props.items
    };
    this.postRequestOnClick = this.postRequestOnClick.bind(this);
    this.handleClick = this.handleClick.bind(this);

    this.handleCoinClick = this.handleCoinClick.bind(this);
    this.handleItemClick = this.handleItemClick.bind(this);
    this.handleServiceClick = this.handleServiceClick.bind(this);
    this.handleCoinReturnClick = this.handleCoinReturnClick.bind(this);
    this.handleVendClick = this.handleVendClick.bind(this);
  }

  render() {
    return (
      <div className="vending-machine">
        <h1>Vending Machine</h1>
        <div className="user-action flex">
          <div className="item-action flex-vertical">
            <TextDisplay message={this.state.message}/>
            <DisplayCabinet items={this.props.items} itemClick={this.handleItemClick}/>
            <ActionButton name="vend" onClick = {this.handleVendClick} />
          </div>

          <div className="coin-action flex-vertical">
            <TextDisplay message={"Available credit "+this.state.availableCredit}/>
            <CoinPanel coins={this.props.coins} coinClick={this.handleCoinClick}/>
            <ActionButton name="coin return" onClick={this.handleCoinReturnClick}/>
          </div>
        </div>
        <div className="service-action">
          <ActionButton name="service" onClick = {this.handleServiceClick}/>
        </div>
        <div className="out">
          <TextDisplay message={this.state.itemsToCollect}/>
        </div>
      </div>
    );
  }

  // consider refactoring to use a single onClick method?
  handleClick(event, url) {
    event.preventDefault();
    this.postRequestOnClick(url);
  }


  handleVendClick(event) {
    event.preventDefault();
    this.postRequestOnClick("http://localhost:4567/vend");
  }


  handleCoinReturnClick(event) {
    event.preventDefault();
    this.postRequestOnClick("http://localhost:4567/coins/return");
  }


  handleCoinClick(event){
    event.preventDefault();
    let coinvalue = event.target.value;
    this.postRequestOnClick("http://localhost:4567/coin/"+coinvalue);
  }

  handleItemClick(event){
    event.preventDefault();
    let itemSelector = event.target.id;
    this.postRequestOnClick("http://localhost:4567/item/"+itemSelector);
  }

  handleServiceClick(event) {
    event.preventDefault();
    this.postRequestOnClick("http://localhost:4567/service");
  }



  postRequestOnClick(url){
    const request = new XMLHttpRequest();
    request.open("POST", url);
    request.addEventListener("load", () => {
      if (request.status === 200) {
        const jsonString = request.responseText;
        const machineStatus = JSON.parse(jsonString);
        this.setState(machineStatus);
      }
    });
    request.send();
  }


}

export default VendingMachine;
