import React, { Component } from "react";

const ActionButton = (props) => (
  <div className="ActionButton">
    <input type="submit" value={props.name} onClick={props.onClick}/>
  </div>
);

export default ActionButton;
