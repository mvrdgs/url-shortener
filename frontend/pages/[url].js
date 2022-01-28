import React, { useEffect, useState } from 'react';
import { useRouter } from 'next/router';
import Loading from '../components/Loading';
import { Flex } from '@chakra-ui/react';

function Url() {
  const { query } = useRouter();
  const { url } = query;
  const [data, setData] = useState(null);
  
  const fetchData = async () => {
    const res = await (await fetch(`http://localhost:8080/${url}`)).json();
    setData(res);
  };

  useEffect(() => {
    url && fetchData();
  }, [url])

  useEffect(() => {
    if (data) {
      window.location.assign(data.url);
    }
  }, [data])

  return (
    <Flex height="100vh" alignItems="center" justifyContent="center">
      <Loading />
    </Flex>
  );
}

export default Url;
