function ListGroup() {
    const items = ['New York', 'Toronto', 'Ottawa', 'Waterloo'];
    items.map(item => <li>{item}</li>)
    return (
        <>
            <h1>List</h1>
            {items.length === 0 ? <p>No item</p> : null}
            <ul className="list-group">
                {items.map((item) => (<li key={item}>{item}</li>))}
            </ul>
        </>
    )
}

export default ListGroup;
