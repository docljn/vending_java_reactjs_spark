import React, { Component } from 'react';

class CoinPanel extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  // get all coins here

  render() {
    return (
      <div className="CoinPanel">
        <Coin/>
        // render all coins here
      </div>
    );
  }
}

export default CoinPanel;
