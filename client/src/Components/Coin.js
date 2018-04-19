import React, { Component } from "react";

class Coin extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="coin">
        <img src="placeholder" alt={"pic of "+this.props.name}/>
        <input type="submit" value={this.props.value} onClick={this.props.onClick}/>
      </div>
    );
  }
}

export default Coin;
