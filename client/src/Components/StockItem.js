import React, { Component } from 'react';

class StockItem extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="stock-item">
        <img src="placeholder" alt={"pic of stock item " + this.props.name}/>
        <input type="submit" value={this.props.name} price={this.props.price} count={this.props.count} onClick={this.props.onClick}/>
      </div>
    );
  }
}

export default StockItem;
