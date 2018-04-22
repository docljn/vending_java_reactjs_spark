import React, { Component } from "react";

class StockItem extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="stock-item">
        <img src="placeholder" alt={"pic of stock item " + this.props.id}/>
        <input type="submit" value={"Select "+this.props.id} onClick={this.props.onClick} id={this.props.id}/>
      </div>
    );
  }
}

export default StockItem;
