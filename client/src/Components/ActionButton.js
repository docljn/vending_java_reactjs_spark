import React, { Component } from 'react';

class ActionButton extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="ActionButton">
        <input type="submit" value="ActionType"/>
      </div>
    );
  }
}

export default ActionButton;
