import React, { Component } from "react";
import StockItem from "./StockItem.js";

class DisplayCabinet extends Component {

  constructor(props) {
    super(props);
  }

  render(){
    const html = this.props.items.map(item => {
      return (
        <StockItem id={item.selector} price={item.price} key={this.props.items.indexOf(item)} onClick={this.props.itemClick}/>
      );
    });


    return (
      <div className="display-cabinet">
        {html}
      </div>
    );
  }
}

export default DisplayCabinet;
