import React, { Component } from "react";
import ItemImage from "../images/ItemImage.js";

const StockItem = (props) => (
  <div className="stock-item">
    <img src={ItemImage[props.id]} alt={"pic of stock item " + props.id}/>
    <br/>
    <input type="submit" value={"Select "+props.id} onClick={props.onClick} id={props.id}/>
  </div>
);

export default StockItem;
