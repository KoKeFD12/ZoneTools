function deleteById(type, id) {
    fetch(type + '/delete/' + id, {method: "DELETE"});
}