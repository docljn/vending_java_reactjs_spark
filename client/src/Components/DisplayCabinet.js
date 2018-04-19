import React, { Component } from "react";
import StockItem from "./StockItem.js";

class DisplayCabinet extends Component {

  constructor(props) {
    super(props);
    console.log("DisplayCabinetProps " + JSON.stringify(props));
  }

  render(){
    const html = this.props.items.map(item => {
      return (
        <StockItem name={item.name} price={item.price} count={item.count} key={this.props.items.indexOf(item)} onClick={this.props.onClick}/>
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
