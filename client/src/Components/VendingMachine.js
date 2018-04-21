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
    this.postOnCoinClick = this.postOnCoinClick.bind(this);
    this.postOnVendClick = this.postOnVendClick.bind(this);
    // get all details of vending machine and set state here.....
  }

  render() {
    return (
      <div className="vending-machine">
        <h1>Vending Machine</h1>
        <div className="user-action flex">
          <div className="item-action flex-vertical">
            <TextDisplay message={this.state.message}/>
            <DisplayCabinet items={this.props.items} selectClick={this.handleSelectClick}/>
            <ActionButton name="vend" onClick = {this.handleVendClick} />
          </div>

          <div className="coin-action flex-vertical">
            <TextDisplay message={"Available credit "+this.state.credit}/>
            <CoinPanel coins={this.props.coins} coinClick={this.handleCoinClick}/>
            <ActionButton name="coin return" onClick={this.handleCoinReturnClick}/>
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
    this.postOnVendClick();
    // put request to /vend/:selectedItem
  }


  handleCoinReturnClick(event) {
    event.preventDefault();
    console.log(event.target);
    this.postOnCoinReturnClick()
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
    let coinvalue = event.target.value;
    this.postOnCoinClick("http://localhost:4567/coin/"+coinvalue);
    console.log(event.target);
  }





  postOnCoinClick(url) {
    const request = new XMLHttpRequest();
    request.open("POST", url);
    request.addEventListener("load", () => {
      if (request.status === 200) {
        const jsonString = request.responseText;
        const credit = JSON.parse(jsonString);
        this.setState({credit: credit});
      }
    });
    request.send();
    console.log("Coin STATUS" + request.status);
  }


  postOnCoinReturnClick() {
    const url = "http://localhost:4567/coin/return";
    const request = new XMLHttpRequest();
    request.open("POST", url);
    request.addEventListener("load", () => {
      if (request.status === 200) {
        const jsonString = request.responseText;
        const credit = JSON.parse(jsonString);
        this.setState({credit: credit, message: "Please make a selection"});
      }
    });
    request.send();
    console.log("return request status"+request.status);
  }

  postOnVendClick() {
    const url = "http://localhost:4567/vend";
    const request = new XMLHttpRequest();
    request.open("POST", url);
    request.addEventListener("load", () => {
      if (request.status === 200) {
        const jsonString = request.responseText;
        const credit = JSON.parse(jsonString);
        this.setState({credit: credit});
      }
    });
    request.send();
    console.log("request status"+request.status);
  }

}

export default VendingMachine;
