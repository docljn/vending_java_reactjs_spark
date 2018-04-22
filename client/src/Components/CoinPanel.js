import React, { Component } from "react";
import Coin from "./Coin.js";


const CoinPanel = (props) => {


  const html = props.coins.map(coin => {
    return (
      <Coin type={coin.type} key={props.coins.indexOf(coin)} coinClick={props.coinClick}/>
    );
  });


  return (
    <div className="coin-panel">
      {html}
    </div>
  );
};

export default CoinPanel;
