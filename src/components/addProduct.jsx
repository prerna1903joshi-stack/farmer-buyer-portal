import React, { useState } from "react";
import "../css_styling/addProduct.css";

const AddProduct = () => {
  const [form, setForm] = useState({
    productName: "",
    category: "",
    quantity: "",
    price: "",
    location: "",
    productImage: null,
    description: ""
  });

  const handleChange = (e) => {
    const { name, value, files } = e.target;
    setForm({ ...form, [name]: files ? files[0] : value });
  };

 const handleSubmit = async (e) => {
  e.preventDefault();

  try {
    const data = new FormData();
    data.append("productName", form.productName);
    data.append("category", form.category);
    data.append("quantity", form.quantity);
    data.append("price", form.price);
    data.append("location", form.location);
    data.append("description", form.description);
    data.append("productImage", form.productImage);

    const response = await fetch("http://localhost:8080/api/products", {
      method: "POST",
      body: data
    });

    if (response.ok) {
      alert("✅ Product added successfully!");
    } else {
      alert("❌ Failed to add product");
    }

  } catch (error) {
    alert("⚠️ Server error. Try again later");
  }
};


  return (
    <div className="product-wrapper">
      <div className="product-card">
        <h2>Add New Product</h2>
        <p className="subtitle">Fill the details to list your crop/product</p>

        <form onSubmit={handleSubmit}>

          <div className="form-group">
            <label>Product Name</label>
            <input
              type="text"
              name="productName"
              placeholder="Eg: Tomato"
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>Category</label>
            <select name="category" onChange={handleChange} required>
              <option value="">Select Category</option>
              <option>Vegetables</option>
              <option>Fruits</option>
              <option>Grains</option>
              <option>Pulses</option>
            </select>
          </div>

          <div className="form-group">
            <label>Quantity (Kg)</label>
            <input
              type="number"
              name="quantity"
              placeholder="Eg: 100"
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>Price per Kg (₹)</label>
            <input
              type="number"
              name="price"
              placeholder="Eg: 40"
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>Location</label>
            <input
              type="text"
              name="location"
              placeholder="Eg: Vijayawada"
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>Upload Product Image</label>
            <input
              type="file"
              name="productImage"
              accept="image/*"
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>Description</label>
            <textarea
              name="description"
              rows="4"
              placeholder="Write product details..."
              onChange={handleChange}
              required
            ></textarea>
          </div>

          <button type="submit" className="submit-btn">
            Add Product
          </button>

        </form>
      </div>
    </div>
  );
};

export default AddProduct;
