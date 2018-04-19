class ItemGetter {

  constructor(item){
    this.item = item;
    this.items = [];
  }

  fetchItems(){
    const url = "http://localhost:4567/items";
    const xhr = new XMLHttpRequest();
    xhr.open("GET", url);

    xhr.onload = () => {
      this.items = JSON.parse(xhr.responseText);

      for (let item of this.items){
        console.log(item);
      }
    };

    xhr.send();
  }
}

export default ItemGetter;
