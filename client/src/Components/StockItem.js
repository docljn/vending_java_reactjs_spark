import React, { Component } from "react";

class StockItem extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="stock-item">
        <img src="placeholder" alt={"pic of stock item " + this.props.selector}/>
        <input type="submit" value={this.props.price} onClick={this.props.onClick} id={this.props.selector}/>
      </div>
    );
  }
}

export default StockItem;
