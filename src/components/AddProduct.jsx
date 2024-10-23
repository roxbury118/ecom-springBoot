import React, { useState } from "react";
import axios from "axios";

const AddProduct = () => {
  const [product, setProduct] = useState({
    p_name: "",
    p_desc: "",
    brand: "",
    price: "",
    catogary: "",
    quant: "",
    release_Date: "",
    available: false,
  });
  const [image, setImage] = useState(null);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setProduct({ ...product, [name]: value });
  };

  const handleImageChange = (e) => {
    setImage(e.target.files[0]);
  };

  const submitHandler = (event) => {
    event.preventDefault();
    
    // Convert product fields to correct types
    const formattedProduct = {
      ...product,
      price: Number(product.price), // Ensure price is a number
      quant: Number(product.quant), // Ensure quantity is a number
      release_Date: product.release_Date, // Ensure this is in YYYY-MM-DD format
    };

    const formData = new FormData();
    formData.append('prod', new Blob([JSON.stringify(formattedProduct)], {
      type: 'application/json'
    }));
    
    if (image) {
      formData.append('imageFile', image);
    }

    axios.post("http://localhost:8080/api/product", formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
    .then((response) => {
      console.log("Product added successfully:", response.data);
      alert("Product added successfully");
      // Reset form after submission
      setProduct({
        p_name: "",
        p_desc: "",
        brand: "",
        price: "",
        catogary: "",
        quant: "",
        release_Date: "",
        available: false,
      });
      setImage(null);
    })
    .catch((error) => {
      console.error("Error adding product:", error.response?.data || error.message);
      alert(`Error adding product: ${error.response?.data || error.message}`);
    });
  };

  return (
    <div className="container">
      <div className="center-container">
        <form className="row g-3 pt-5" onSubmit={submitHandler}>
          <div className="col-md-6">
            <label className="form-label">
              <h6>Product Name</h6>
            </label>
            <input
              type="text"
              className="form-control"
              placeholder="Product Name"
              onChange={handleInputChange}
              value={product.p_name}
              name="p_name"
            />
          </div>
          <div className="col-md-6">
            <label className="form-label">
              <h6>Brand</h6>
            </label>
            <input
              type="text"
              name="brand"
              className="form-control"
              placeholder="Enter your Brand"
              value={product.brand}
              onChange={handleInputChange}
              id="brand"
            />
          </div>
          <div className="col-12">
            <label className="form-label">
              <h6>Description</h6>
            </label>
            <input
              type="text"
              className="form-control"
              placeholder="Add product description"
              value={product.p_desc}
              name="p_desc"
              onChange={handleInputChange}
              id="p_desc"
            />
          </div>
          <div className="col-5">
            <label className="form-label">
              <h6>Price</h6>
            </label>
            <input
              type="number"
              className="form-control"
              placeholder="Eg: $1000"
              onChange={handleInputChange}
              value={product.price}
              name="price"
              id="price"
            />
          </div>

          <div className="col-md-6">
            <label className="form-label">
              <h6>Category</h6>
            </label>
            <select
              className="form-select"
              value={product.catogary}
              onChange={handleInputChange}
              name="catogary"
              id="catogary"
            >
              <option value="">Select category</option>
              <option value="Laptop">Laptop</option>
              <option value="Headphone">Headphone</option>
              <option value="Mobile">Mobile</option>
              <option value="Electronics">Electronics</option>
              <option value="Toys">Toys</option>
              <option value="Fashion">Fashion</option>
            </select>
          </div>

          <div className="col-md-4">
            <label className="form-label">
              <h6>Stock Quantity</h6>
            </label>
            <input
              type="number"
              className="form-control"
              placeholder="Stock Remaining"
              onChange={handleInputChange}
              value={product.quant}
              name="quant"
              id="quant"
            />
          </div>
          <div className="col-md-4">
            <label className="form-label">
              <h6>Release Date</h6>
            </label>
            <input
              type="date"
              className="form-control"
              value={product.release_Date}
              name="release_Date"
              onChange={handleInputChange}
              id="release_Date"
            />
          </div>
          <div className="col-md-4">
            <label className="form-label">
              <h6>Image</h6>
            </label>
            <input
              className="form-control"
              type="file"
              onChange={handleImageChange}
            />
          </div>
          <div className="col-12">
            <div className="form-check">
              <input
                className="form-check-input"
                type="checkbox"
                name="available"
                id="gridCheck"
                checked={product.available}
                onChange={(e) =>
                  setProduct({ ...product, available: e.target.checked })
                }
              />
              <label className="form-check-label">Product Available</label>
            </div>
          </div>
          <div className="col-12">
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default AddProduct;
