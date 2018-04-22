import React, { Component } from "react";
import StockItem from "./StockItem.js";

const DisplayCabinet = (props) =>  {




  const html = props.items.map(item => {
    return (
      <StockItem id={item.selector} key={props.items.indexOf(item)} onClick={props.itemClick}/>
    );
  });


  return (
    <div className="display-cabinet">
      {html}
    </div>
  );
};

export default DisplayCabinet;
