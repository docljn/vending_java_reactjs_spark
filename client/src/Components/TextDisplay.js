import React, { Component } from "react";

class TextDisplay extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="TextDisplay">
        <h3>{this.props.message}</h3>
      </div>
    );
  }
}

export default TextDisplay;
