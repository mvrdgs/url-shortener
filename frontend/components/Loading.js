import React from 'react';
import { Spinner } from '@chakra-ui/react';

function Loading() {
  return (
    <Spinner
      thickness='4px'
      speed='1s'
      emptyColor='gray.200'
      color="rgba(152,193,76,1)"
      size='xl'
    />
  );
}

export default Loading;