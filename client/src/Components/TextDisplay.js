import React, { Component } from "react";

class TextDisplay extends Component {

  constructor(props) {
    super(props);
    // this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div className="TextDisplay">
        <p>{this.props.message}</p>
      </div>
    );
  }
}

export default TextDisplay;
