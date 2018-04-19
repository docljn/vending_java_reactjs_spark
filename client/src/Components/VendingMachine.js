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
      items:[
        {
          "name": "A",
          "price": 65,
        },
        {
          "name": "B",
          "price": 100,
        },
        {
          "name": "C",
          "price": 100,
        }
      ],

      coins:[
        {
          "name": "NICKEL",
          "value": 5
        },
        {
          "name": "DIME",
          "value": 10
        },{
          "name": "QUARTER",
          "value": 25
        },{
          "name": "DOLLAR",
          "value": 100
        }
      ]
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
            <DisplayCabinet items={this.state.items} onClick={this.handleSelectClick}/>
            <ActionButton name="vend" onClick = {this.handleVendClick} />
          </div>

          <div className="coin-action flex-vertical">
            <TextDisplay message={this.state.credit}/>
            <CoinPanel coins={this.state.coins} onClick={this.handleCoinClick}/>
            <ActionButton name="coin return" onClick = {this.handleCoinClick}/>
          </div>
        </div>
        <div className="service-action">
          <ActionButton name="service" onClick = {this.handleServiceClick}/>
        </div>
      </div>


    );
  }

  initialize(){
    // call service
    // setstate items
    const availableItems =
    this.setState(prevState => {
      return {total: prevState.total + this.props.depositAmount};
    });
    // setstate coins

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
