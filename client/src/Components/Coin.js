import React, { Component } from "react";
import CoinImage from "../images/CoinImage";

const Coin = (props) => (
  <div className="coin">
    <img src={CoinImage[props.type]} alt={"pic of "+props.type}/>
    <br/>
    <input type="submit" id={props.type} value={"Add "+props.type} onClick={props.coinClick}/>
  </div>
);

export default Coin;
