function deleteById(id) {
    fetch('movements/delete/' + id, {method: "DELETE"});
}