import React, { useState, useEffect } from "react";
import { makeStyles } from "@material-ui/core/styles";
import {
  Paper,
  Container,
  AppBar,
  Typography,
  Box,
  Tabs,
  Tab,
  Grid,
} from "@material-ui/core";
import TableHead from "./UpperTable";
import TableLower from "./LowerTable";
import TableToolbar from "./TableToolbar";
import axios from "axios";

import ChatIcon from '@material-ui/icons/Chat';

const headCells = [
  { id: "rank", label: "순위", color: "yellow" },
  { id: "streamer", label: "스트리머", color: "yellow" },
  { id: "chatting", label: "실시간채팅", color: "yellow" },
  { id: "viewer", label: "시청자", color: "yellow" },
  { id: "follower", label: "팔로워", color: "yellow" },
  { id: "time", label: "방송시간", color: "yellow" },
  { id: "endBroadCasting", label: "마지막방송", color: "yellow" },
];

function createData(
  number,
  name,
  rowChatting,
  rowViewer,
  rowFollower,
  rowTime,
  rowEndBroadCasting
) {
  return {
    number,
    name,
    rowChatting,
    rowViewer,
    rowFollower,
    rowTime,
    rowEndBroadCasting,
  };
}

function a11yProps(index) {
  return {
    id: `full-width-tab-${index}`,
    "aria-controls": `full-width-tabpanel-${index}`,
  };
}

const useStyle = makeStyles((theme) => ({
  tab: {
    color: "#e53e3e",
    minWidth: "50px",
    width: "50px",
  },
  indicator: {
    backgroundColor: "white",
  },
}));

const RankingTable = () => {
  const classes = useStyle();
  const [value, setValue] = useState(2);
  const bottomColors = ["#e53e3e", "#d69e2e", "#805ad5", "#dd6b20", "#38a169"];
  const [sstyle, setSstyle] = useState([0, 0, 0, 0, 0]);
  const style2 = [
    { background: "#ffffff", color: "#000000" },
    { background: "#e53e3e", color: "#ffffff" },
    { background: "#d69e2e", color: "#ffffff" },
    { background: "#805ad5", color: "#ffffff" },
    { background: "#dd6b20", color: "#ffffff" },
    { background: "#38a169", color: "#ffffff" },
  ];
  const [rows, setRows] = useState(null);
  const tabsNames = [
    "실시간 채팅속도",
    "실청자",
    "평청자",
    "팔로워",
    "방송시간",
    "마지막방송 시간",
  ];

  useEffect(() => {
    axios.get("http://localhost:8080/streams").then((response) => {
      setRows(response.data);
    });
  }, []);

  const test = (index) => {
    const tmp = sstyle.slice();
    tmp[index] = index + 1;
    setSstyle(tmp);
  };

  const mouseLeave = (index) => {
    const tmp = sstyle.slice();
    tmp[index] = 0;
    setSstyle(tmp);
  };

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <Container style={{ marginTop: 50}} maxWidth="lg" >
      <Paper elevation={7}>
        <TableToolbar/>
        <Grid>
          <Tabs
            value={value}
            onChange={handleChange}
            TabIndicatorProps={{
              style: {
                background: bottomColors[value - 2],
                color: "white",
              },
            }}
            variant="fullWidth"
          >
            <Tab label="순위" disabled />
            <Tab label="스트리머" disabled />
            {tabsNames.map((tabsName, index) => (
              <Tab
                key={index}
                label={<span><ChatIcon/>{tabsName}</span>}
                onMouseOver={() => test(index)}
                onMouseLeave={() => mouseLeave(index)}
                style={style2[sstyle[index]]}
                {...a11yProps(index)}
              ></Tab>
            ))}
          </Tabs>
        </Grid>
        <TableLower rowCells={rows}></TableLower>
      </Paper>
    </Container>
  );
};

export default RankingTable;
