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
      selected:{},
      items:[
        {
          "name": "A",
          "price": 65,
          "count": 1
        },
        {
          "name": "B",
          "price": 100,
          "count": 1
        },
        {
          "name": "C",
          "price": 100,
          "count": 1
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

    // get all details of vending machine and set state here.....
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="vending-machine">
        <div className="user-action flex">
          <div className="item-action flex-vertical">
            <TextDisplay message={this.state.message}/>
            <DisplayCabinet items = {this.state.items}/>
            <ActionButton name="vend" onClick = "some method" />
          </div>

          <div className="coin-action flex-vertical">
            <TextDisplay message={this.state.credit}/>
            <CoinPanel coins = {this.state.coins}/>
            <ActionButton name="coin return" onClick = "some method"/>
          </div>
        </div>
        <div className="service-action">
          <ActionButton name="service" onClick = "some method"/>
        </div>
      </div>


    );
  }

  handleVendButtonClick() {
    // post request to /vend:selectedItem
  }

}

export default VendingMachine;
