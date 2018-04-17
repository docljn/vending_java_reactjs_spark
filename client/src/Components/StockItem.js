import React, { Component } from 'react';

class StockItem extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="StockItem">
        <img src="placeholder" alt="StockItem Name, Price"/>
        <input type="submit" value="SelectStockItem ItemName"/>
      </div>
    );
  }
}

export default StockItem;
