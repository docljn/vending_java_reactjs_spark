import React, { Component } from 'react';
import './App.css';

class Coin extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="Coin">
        <img src="placeholder" alt="Coin Name, Value"/>
        <input type="submit" value="CoinType"/>
      </div>
    );
  }
}

export default Coin;
