import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import FarmerLayout from "./farmer/layout/FarmerLayout";
import Home from "./farmer/pages/Home";
import AddProduct from "./farmer/pages/AddProduct";
import MyProducts from "./farmer/pages/MyProducts";
import Orders from "./farmer/pages/Orders";
import Payments from "./farmer/pages/Payments";
import Profile from "./farmer/pages/Profile";

export default function App() {
  return (
    <Router>
      <Routes>
        <Route path="/farmer" element={<FarmerLayout />}>
          <Route path="dashboard" element={<Home />} />
          <Route path="add-product" element={<AddProduct />} />
          <Route path="my-products" element={<MyProducts />} />
          <Route path="orders" element={<Orders />} />
          <Route path="payments" element={<Payments />} />
          <Route path="profile" element={<Profile />} />
        </Route>
      </Routes>
    </Router>
  );
}
