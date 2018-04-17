import React, { Component } from 'react';

class DisplayCabinet extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  // get all stock items here....

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
