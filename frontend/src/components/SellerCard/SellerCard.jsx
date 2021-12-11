import React from 'react';
import { generatePath, useNavigate } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { Card } from 'react-bootstrap';

import { selectSellerById } from '../../store/sellersSlice';
import { CATEGORIES, ROUTES } from '../../consts/consts';

function SellerCard({ id, filter }) {
  const sellerInfo = useSelector(state => selectSellerById(state, id));
  // console.log(sellerInfo);
  const { seller_name, seller_categories } = sellerInfo;
  const isVisible = filter === CATEGORIES.ALL ? true : seller_categories.includes(filter);

  const navigate = useNavigate();
  const handleCardClick = () => {
    navigate(
      generatePath(ROUTES.SELLER, {
        id,
      })
    );
  };

  return (
    isVisible && (
      <Card bg="light" style={{ width: '18rem', marginRight: '1rem', marginBottom: '1rem' }} onClick={handleCardClick}>
        <Card.Header>{seller_name}</Card.Header>
        <Card.Body>
          <Card.Title>{seller_name} sells:</Card.Title>
          <ul>
            {seller_categories.map(category => {
              return <li key={category}>{category}</li>;
            })}
          </ul>
        </Card.Body>
      </Card>
    )
  );
}

export default SellerCard;