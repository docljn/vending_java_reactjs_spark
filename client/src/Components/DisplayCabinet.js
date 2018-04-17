import React, { Component } from "react";
import StockItem from "./StockItem.js";

class DisplayCabinet extends Component {

  constructor(props) {
    super(props);
  }


  render() {
    return (
      <div className="DisplayCabinet">
        <StockItem/>
        // render all stock items here
      </div>
    );
  }
}

export default DisplayCabinet;
