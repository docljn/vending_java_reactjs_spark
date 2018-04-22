import React, { Component } from "react";
import ItemImage from "../images/ItemImage.js";

class StockItem extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="stock-item">
        <img src={ItemImage[this.props.id]} alt={"pic of stock item " + this.props.id}/>
        <br/>
        <input type="submit" value={"Select "+this.props.id} onClick={this.props.onClick} id={this.props.id}/>
      </div>
    );
  }
}

export default StockItem;
